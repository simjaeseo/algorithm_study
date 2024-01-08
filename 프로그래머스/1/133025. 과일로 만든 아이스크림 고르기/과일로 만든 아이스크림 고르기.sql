-- 코드를 입력하세요
SELECT FH.FLAVOR
    FROM FIRST_HALF as FH JOIN ICECREAM_INFO as II
        WHERE FH.FLAVOR = II.FLAVOR AND FH.TOTAL_ORDER >= 3000 AND II.INGREDIENT_TYPE = 'fruit_based'
            ORDER BY FH.TOTAL_ORDER DESC