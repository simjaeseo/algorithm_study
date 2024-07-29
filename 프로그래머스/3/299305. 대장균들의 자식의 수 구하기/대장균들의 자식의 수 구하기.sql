-- 코드를 작성해주세요
select ed1.id, ifnull(ed2.count_id, 0) as CHILD_COUNT
    from ecoli_data ed1
        left outer join
    (select parent_id, count(id) as count_id
        from ecoli_data
            where parent_id is not null
                group by parent_id) as ed2
                on ed1.id = ed2.parent_id