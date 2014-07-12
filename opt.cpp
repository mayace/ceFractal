void opt_opt_1__1(){

l0:
}
void void_main_1__1(){

t0 = p + 0;
t1 = 0;
stack[t0] = 0;
l2:
t2 = t0;
t3 = stack[t2];
t4 = 10;
if t3 < t4 then goto l4;
goto l5;
l4:
t5 = p + 1;
t6 = t5 + 0;
t7 = t2;
t8 = stack[t7];
stack[t6] = t8;
p = t5;
call printNum();
p = t5 - 1;
t9 = t5;
t10 = t6;
t11 = h;
h = h + 2;
t12 = h + 0;
heap[t12] = 10;
t13 = h + 1;
heap[t13] = -1;
t14 = t12;
t15 = heap[t14];
stack[t10] = t15;
p = t9;
call printChar();
p = t5 - 1;
t16 = t7;
t17 = stack[t16];
t18 = t17 + 1;
stack[t16] = t18;
goto l2;
l5:
l3:
l1:
}
