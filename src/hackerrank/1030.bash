# 1
echo "HELLO"

# 2
for ((i=1;i<51;i++))
do
    j=$((i * 2 -1))
    echo "$j"
done

# 3
read name
echo "Welcome $name"

# 4
for ((i=1;i<51;i++))
do
    echo "$i"
done

# 5
read a
read b
echo $((a+b))
echo $((a-b))
echo $((a*b))
echo $((a/b))
