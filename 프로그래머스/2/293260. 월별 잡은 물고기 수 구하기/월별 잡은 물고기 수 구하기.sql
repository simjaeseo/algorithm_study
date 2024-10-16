SELECT
    count(id) as FISH_COUNT, month(time) as MONTH
FROM
    FISH_info
GROUP BY
    MONTH
order by
    month