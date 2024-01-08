-- 코드를 입력하세요
SELECT round(SUM(DAILY_FEE)/COUNT(CAR_ID), 0)
    from CAR_RENTAL_COMPANY_CAR
        where CAR_TYPE = 'SUV';