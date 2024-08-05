select hd.DEPT_ID as DEPT_ID, hd.dept_name_en as DEPT_NAME_EN, ROUND(hm.avg, 0) AS AVG_SAL
    from hr_department hd
        join
            (select dept_id, avg(sal) as avg
                from hr_employees
                    group by dept_id) as hm
                        on hd.dept_id = hm.dept_id
                            order by avg_sal desc