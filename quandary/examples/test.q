int main(int arg) {
    
    mutable int x = 0;

    while (x < 5) {
        print(x);
        int y = x;
        x = y + 1;
    }
    return x;
}