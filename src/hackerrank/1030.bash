# 1 출력
echo "HELLO"

# 2 반복문
for ((i=1;i<51;i++))
do
    j=$((i * 2 -1))
    echo "$j"
done

# 3 변수 입출력
read name
echo "Welcome $name"

# 4 반복문
for ((i=1;i<51;i++))
do
    echo "$i"
done

# 5 연산
read a
read b
echo $((a+b))
echo $((a-b))
echo $((a*b))
echo $((a/b))
