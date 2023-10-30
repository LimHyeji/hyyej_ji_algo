echo "HELLO"

for ((i=1;i<51;i++))
do
    j=$((i * 2 -1))
    echo "$j"
done

read name
echo "Welcome $name"

for ((i=1;i<51;i++))
do
    echo "$i"
done

read a
read b
echo $((a+b))
echo $((a-b))
echo $((a*b))
echo $((a/b))
