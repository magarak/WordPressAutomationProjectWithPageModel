#######TAGS########
# tags @fıtıfıtı featuredaysa tüm senaryoları çalıştırır
# tags @fıtıfıtı senaryodaysa yalnızca verilen senaryo
# tags ~@fıtıfıtı bu senaryoyu çalıştırma git diğer hepsinden devam et
# tags @fıtıtı tags @fıt --AND operation kesişimi alır
# tags @fıtıfıtı,@fıt --OR operation toplamı bunu ya da bunu

#####HOOKS########
#hooks are blocks of code that can run at various points in the Cucumber execution cycle
# Before Hook - before every scenario is executed
# BackGround - is execute before every scenario
#Before Hook --> Background --> scenario 1--After Hook
#Before Hook --> Background --> scenario 2--After Hook

#examplesla aynı senaryo içersinde birden fazla data ile senaryo koşmaca--> Data Driven Concept
#

Feature: Test Login Feature

  Scenario Outline: Test login functionality with valid credentials
    Given open wordpress application
    When click on login link
    Then login page should appear
    When enter user name <userName>
    When click on continue button
    When enter password <password>
    When click on login button
    Then login should be successful
                Examples:
                        | userName | password |
                        | "merve"  | "agarak" |
                        | "cem"  | "agarak" |