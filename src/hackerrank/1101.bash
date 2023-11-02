#11 재귀를 통한 출력
declare -A matrix
read N
rows=63
cols=100

for ((i=0;i<rows;i++)) do
    for ((j=0;j<cols;j++)) do
        matrix[$i,$j]='_'
    done
done

tree(){
    if [ $4 -gt 0 ] && [ $4 -le 5 ]
    then
        for i in $(seq 0 $(($3-1)))
        do
            matrix[$(($1-$i)),$2]='1'
            matrix[$(($1-$3-$i)),$(($2-$i-1))]='1'
            matrix[$(($1-$3-$i)),$(($2+$i+1))]='1'
        done
        tree $(($1-$3*2)) $(($2-$3)) $(($3/2)) $(($4-1))
        tree $(($1-$3*2)) $(($2+$3)) $(($3/2)) $(($4-1))
    fi
}

#tree($row, $col, $len, $N)
#     $1    $2    $3    $4
tree 62 49 16 $N

for ((i=0;i<rows;i++)) do
    for ((j=0;j<cols;j++)) do
        printf ${matrix[$i,$j]}
    done
    printf '\n'
done

## Text Processing
