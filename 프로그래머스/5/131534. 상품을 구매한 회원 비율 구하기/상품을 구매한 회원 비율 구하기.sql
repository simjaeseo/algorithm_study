-- 코드를 입력하세요
SELECT YEAR(OS.SALES_DATE) YEAR, MONTH(OS.SALES_DATE) AS MONTH, COUNT(DISTINCT UI.USER_ID) AS PUCHASED_USERS, ROUND(COUNT(DISTINCT UI.USER_ID) / (SELECT COUNT(*) FROM USER_INFO WHERE YEAR(JOINED) = '2021'),1) AS PUCHASED_RATIO
    FROM USER_INFO UI JOIN ONLINE_SALE OS
        ON UI.USER_ID = OS.USER_ID AND YEAR(UI.JOINED) = 2021
            GROUP BY YEAR(OS.SALES_DATE), MONTH(OS.SALES_DATE)
                ORDER BY YEAR(OS.SALES_DATE), MONTH(OS.SALES_DATE)