-- 코드를 입력하세요
SELECT  UGU.USER_ID as USER_ID, UGU.NICKNAME as NICKNAME, SUM(UGB.PRICE)
    FROM USED_GOODS_BOARD UGB JOIN USED_GOODS_USER UGU
        ON UGB.WRITER_ID = UGU.USER_ID
            WHERE UGB.STATUS = 'DONE'
                GROUP BY UGB.WRITER_ID
                    HAVING SUM(UGB.PRICE) >= 700000
                        ORDER BY SUM(UGB.PRICE)
                