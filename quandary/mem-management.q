mutable Q main (int arg) {

    if (arg == 1) return question1();
    if (arg == 2) return question2();
    if (arg == 3) return question3();
    if (arg == 4) return question4();
    return nil;


}

Ref create(int n) {

    if (n == 0) return nil;
    return  n . create (n-1);

}

mutable Ref createCycle() {

    Ref list1 = nil . nil;
    Ref list2 = nil . nil;
    setRight(list1, list2);
    setRight(list2, list1);

    return list1;
}

Q question1() {
    Ref list = create(17);
    return 1;
}

mutable Q question2() { 
    mutable int n = 0;
    while (n < 20) {
        Ref list = createCycle();
        n = n + 1;
    }
    return 2;
}

Q question3() {
    Ref list = create(10);
    free list;
    Ref list2 = create(7);
    return 3;
}

Q question4() {
    mutable int n = 0;
    while (n < 20) {
        Ref list = create(5);
        n = n + 1;
    }
    return 4;
}
