select count(fi2.length) as FISH_COUNT, max(fi2.length) as MAX_LENGTH, fi1.fish_Type as FISH_TYPE
    from fish_info fi1
        join
            (select ID, FISH_TYPE, ifnull(LENGTH, 10) as LENGTH, TIME from fish_INFO) as fi2
                on fi1.id = fi2.id
                    group by fi1.fish_type
                        having avg(fi2.length) >= 33
                            order by fish_type