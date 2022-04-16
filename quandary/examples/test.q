Q main(int arg) {
    mutable int n = arg;
    while (n >= 0) {
        print(replicate(n));
        n = n - 1;
    }
    return nil;
}

int replicate(int n) {
    return n;
}