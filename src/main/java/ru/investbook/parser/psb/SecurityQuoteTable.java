/*
 * InvestBook
 * Copyright (C) 2021  Vitalii Ananev <spacious-team@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ru.investbook.parser.psb;

import org.spacious_team.broker.pojo.SecurityQuote;
import org.spacious_team.table_wrapper.api.TableRow;
import ru.investbook.parser.SingleAbstractReportTable;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static ru.investbook.parser.psb.SecuritiesTable.SecuritiesTableHeader.*;

public class SecurityQuoteTable extends SingleAbstractReportTable<SecurityQuote> {

    private final BigDecimal minValue = BigDecimal.valueOf(0.01);

    public SecurityQuoteTable(PsbBrokerReport report) {
        super(report, SecuritiesTable.TABLE_NAME, SecuritiesTable.TABLE_END_TEXT,
                SecuritiesTable.SecuritiesTableHeader.class);
    }

    @Override
    protected SecurityQuote parseRow(TableRow row) {
        if (row.rowContains(SecuritiesTable.INVALID_TEXT)) {
            return null;
        }
        int count = row.getIntCellValue(OUTGOING);
        if (count == 0) {
            return null;
        }
        BigDecimal amount = row.getBigDecimalCellValue(AMOUNT);
        BigDecimal price = amount.divide(BigDecimal.valueOf(count), 4, RoundingMode.HALF_UP);
        BigDecimal quote = row.getBigDecimalCellValue(QUOTE);
        BigDecimal accruedInterest = row.getBigDecimalCellValue(ACCRUED_INTEREST)
                .divide(BigDecimal.valueOf(count), 2, RoundingMode.HALF_UP);
        if (accruedInterest.compareTo(minValue) < 0 && price.subtract(quote).abs().compareTo(minValue) < 0) {
            // акция
            price = null;
            accruedInterest = null;
        }
        return SecurityQuote.builder()
                .security(row.getStringCellValue(ISIN))
                .timestamp(getReport().getReportEndDateTime())
                .quote(quote)
                .price(price)
                .accruedInterest(accruedInterest)
                .build();
    }
}
