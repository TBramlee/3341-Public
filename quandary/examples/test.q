Q main(int arg) {
    
    Ref list1 = nil. nil;
    Ref list2 = 4. 3 . 2 . 1;



    return [ printStuff(arg, list1) . printStuff(arg, list2) ];
}

Q printStuff(int n, Ref list) {
    if (n > 0) {
        print (list);
        return printStuff(n - 1, list);
    }
    return nil . nil;
}