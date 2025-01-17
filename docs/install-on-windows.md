### Установка и работа на Windows

Данная инструкция поддерживает версию Windows x64. Если у вас 32 битная Windows, рекомендуем устанавливать по
[инструкции](install-on-windows-by-zip.md).
1. Скачать со страницы [проекта](https://github.com/spacious-team/investbook/releases/latest) установщик `.msi`
   и запустить его.
1. Если вы обновляете приложение и в процессе обновления появилось показанное ниже окно - это означает, что запущена 
   предыдущая версия приложения. Перед нажатием кнопки `ОК` нужно открыть в браузере сайт `http://localhost` и остановить
   приложение `Investbook`, нажав в верхнем правом углу пиктограмму `Завершить`. Если сайт не открывается - запустите
   Диспетчер задач сочетанием клавиш `Ctrl+Shift+Esc` и остановите процесс `Investbook.exe`.
   ![close-app](https://user-images.githubusercontent.com/11336712/109365987-5ec67980-78a3-11eb-8709-cc18dda60554.png)
1. На рабочем столе появится ярлык `Investbook`, запустите его - откроется браузер и отобразится страница приложения.
   Если браузер не открылся в течении 5-30 сек (в зависимости от производительности вашего компьютера),
   откройте сайт `http://localhost` (это локальный сайт, запущенный приложением на вашем компьютере).
1. Если страница не открылась, ознакомьтесь с возможными причинами и [решениями проблем](/src/main/asciidoc/troubleshooting.adoc).
1. Перейти в раздел `Загрузить отчеты брокера`, выбрать отчеты брокера, которые хотите проанализировать, и нажать кнопку
   `Загрузить`. Или загрузите отчет из email ящика. Или воспользоваться разделом `Форм` для ручного ввода информации.
1. Нажать `Аналитика`. С форматом аналитического отчета можно ознакомиться в [документации](/src/main/asciidoc/index.adoc). 
1. По окончании работы нажмите в верхнем правом углу пиктограмму `Завершить`, если желаете выгрузить приложение
   из памяти компьютера. Или оставьте приложение в памяти для быстрого повторного запуска (тогда для запуска
   приложения достаточно будет открыть браузер и перейти по адресу `http://localhost`).

#### Установка расширений

Если вы хотите установить расширение Investbook для поддержки новых Брокеров, то получите его у разработчиков расширений
и поместите jar-файл в директорию `<директория-установки>/app/extensions/`. 