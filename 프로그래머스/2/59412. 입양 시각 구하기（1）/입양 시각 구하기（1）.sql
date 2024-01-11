-- 코드를 입력하세요
SELECT HOUR(DATETIME) as HOUR, COUNT(*) as COUNT
    FROM ANIMAL_OUTS 
        GROUP BY HOUR
            HAVING HOUR >= 9 AND HOUR < 20
            # HAVING HOUR BETWEEN 9 AND 19
                ORDER BY HOUR
                # HAVING DATE_FORMAT(DATETIME, '%h') > 9 AND DATE_FORMAT(DATETIME, '%h') < 20
    