#6 수 비교
read a
read b

if [[ $a -lt $b ]]
then
    echo "X is less than Y"

elif [[ $a -gt $b ]]
then
    echo "X is greater than Y"
else
    echo "X is equal to Y"
fi

#7 조건문
read a

if [[ $a == "Y" || $a == "y" ]]
then
    echo "YES"
else
    echo "NO"
fi

#8 다중 조건문
read a
read b
read c

if [[ $a == $b && $b == $c ]]
then echo "EQUILATERAL"
elif [[ $a == $b || $a == $c || $b == $c ]]
then echo "ISOSCELES"
else echo "SCALENE"
fi

#9 입력문 연산
read x

var=$(echo "scale=4; $x" | bc)
printf "%.3f\n" "$var"

#10 평균 계산
read n

sum=0
for ((i=0;i<n;i++))
do
    read a
    sum=$((a+sum))
done

sum=$(echo "scale=4; $sum/$n" | bc)
printf "%.3f\n" "$sum"