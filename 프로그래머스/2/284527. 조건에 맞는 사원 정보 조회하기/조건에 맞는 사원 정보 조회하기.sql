SELECT SCORE, EMP_NO, EMP_NAME, POSITION, EMAIL
    FROM HR_EMPLOYEES HE
        join HR_DEPARTMENT HD
            using (DEPT_ID)
                join (
SELECT EMP_NO, SUM(SCORE) as SCORE
    FROM HR_GRADE
        GROUP BY EMP_NO
            ORDER BY SUM(SCORE) DESC
                LIMIT 1
) as EN
    using (EMP_NO)
