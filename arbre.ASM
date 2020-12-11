(; ( let  prixHt 200 )( let  prixTtc (/ (* prixHt 119 )100 )))
DATA SEGMENT
    prixHt  DD
    prixTtc  DD
DATA ENDS
CODE SEGMENT
	mov eax, 200 

	mov prixHt , eax

	mov eax, prixHt 

	push eax

	mov eax, 119 

	pop ebx

	mul eax, ebx

	push eax

	mov eax, 100 

	pop ebx

	div ebx, eax

	mov eax, ebx

	mov prixTtc , eax

CODE ENDS
