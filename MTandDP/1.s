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


	for(i=0;i<2000;i++)
		for(j=0;j<3000;j++)
			x_array[i][j] = Y_array[j][i] + 200
	li $s0,Y_array
	li $s1,X_array
	li $t0,2500 // $t0 is a counter for the outer loop
	// $t1 is i
Outer: 
	add $t2,$0,$0 // $t2 = j
Inner: 
	li $t3,Y_ARRAY_SIZE_1 // load vector register with next 8 Y_array elements
	mult $t3,$t2 // Y_array[j]
	mflo $t4
	add $t4,$s1,$t4 // $t4 is &Y_array[j]
	li $t1, 0 // loop 8 times to load mm register
mmx:
	sll $t3,$t1,2 // assume 32-bit words
	add $t5,$t4,$t3 // &Y_array[j][i]
	ld $mm1,$t1,0($t5) // load Y_array[j][i] into
	addi $t4,$t4,Y_ARRAY_SIZE_1 // column size of array
	addi $t1,$t1,1
	slti $t1,8
	beq $t1,mmx
	
	// at this point mm register 0 has 8 elements, j to j+7
	// assume mmuls is an instruction to multiply a wide reg
	// by a scalar, and mmadds is similar

	mmadds $mm1,$mm1,#200 // Y_array[j:j+7][i] + 200 // store 8 entries starting at X_Array[i][j]
	li $t3,Y_ARRAY_SIZE_1
	mult $t3,$t1 // X_array[i]
	sll $t4,$t2,2 // j in terms of words
	add $t4,$t4,$t3 // & [i][j]
	add $t4,$s0,$t4 // &X_array[i][j]
	mmst $mm1,0($t4) // store to X_array[i][j:j+7]
	addi $t2,$t2,8 // advance j
	slt $t3,$t2,3500
	beq $t3,Inner
	// here there should be some code to fix up the last
	// bits of the array, since 3500 is not evenly divisible
	// by 8. An exercise left to the reader
	addi $t1,$t1,1
	addi $t0,$t1,-1
	bne $t0,Outer

