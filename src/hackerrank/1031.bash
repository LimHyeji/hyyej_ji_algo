#6
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

#7
read a

if [[ $a == "Y" || $a == "y" ]]
then
    echo "YES"
else
    echo "NO"
fi

#8
read a
read b
read c

if [[ $a == $b && $b == $c ]]
then echo "EQUILATERAL"
elif [[ $a == $b || $a == $c || $b == $c ]]
then echo "ISOSCELES"
else echo "SCALENE"
fi

#9
read x

var=$(echo "scale=4; $x" | bc)
printf "%.3f\n" "$var"

#10
