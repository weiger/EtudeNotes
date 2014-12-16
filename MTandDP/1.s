	for(i=0;i<2000;i++)
		for(j=0;j<3000;j++)
			x_array[i][j] = Y_array[j][i] + 200
	li $s0,Y_array
	li $s1,X_array
	li $s3,200
	li $t0,500
	li $t1,START // index, 0,500,1000,200 for 4 threads
outer:
	add $t2,$0,$0 //$t2=j
inner:
	li $t3,Y_ARRAY_SIZE_1
	mult $t3,$t2	//Y_array[j]
	mflo $t4
	add $t4,$s1,$t4	//$t4 is &Y_array[j]
	sll $t3,$t1,2 	//assume 32-bit words
	add $t4,$t4,$t3 //&Y_array[j][i]
	ld $t4,0($t4)	//load Y_array[j][i]
	add $t4,$t4,$t3 //Y_array[j][i]+200
	li $t3,X_ARRAY_SIZE_1
	mult $t3,$t1	//size of X_array[]
	mflo $t3
	add $t3,$s0,$t3 //&X_array[i]
	sll $t5,$t2,2 //32 bits
	add $t3,$t5,$t3 //$t3 is &X_array[i][j]
	st $t4,0($t3)
	addi $t2,$t2,1
	slt $t3,$t2,3000
	beq $t3,Inner
	addi $t1,$t1,1
	addi $t0,$t1,-1
	bne $t0,Outer
