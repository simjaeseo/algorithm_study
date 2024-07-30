-- 코드를 작성해주세요
select ID, CASE 
        WHEN SIZE_OF_COLONY <= 100 then 'LOW'
        WHEN SIZE_OF_COLONY <= 1000 then 'MEDIUM'
        else 'HIGH'
        end as SIZE
    from ECOLI_DATA
        ORDER BY ID