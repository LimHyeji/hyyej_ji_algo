## Text Processing - Cut 명령어
# 1
while read line;
do
    echo "${line}" | cut -c3
done

# 2
while read line;
do
    echo "${line}" | cut -c 2,7
done

# 3
while read line;
do
    echo "${line}" | cut -c 2-7
done

# 4
while read line;
do
    echo "${line}" | cut -c 1-4
done

# 5
while read line;
do
    echo "${line}" | cut -f 1-3
done


# 6
while read line;
do
    echo "${line}" | cut -c 13-
done

# 7
while read line;
do
    echo "${line}" | cut -d ' ' -f 4
done