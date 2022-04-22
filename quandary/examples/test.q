Q main(int arg) {
    
    Ref list1 = nil . nil;
    Ref list2 = 4 . 3 . 2 . 1;
    int first = arg;
    int second = arg * 2;



    return [ doStuff(arg, list1) + doStuff(arg, list2) ];
}

int doStuff(int n, Ref list) {
    if (n > 0) {
        print(n);
        print(list);
    return doStuff(n - 1, list);
    }
    return -10;
    
}

