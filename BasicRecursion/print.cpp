void print(int n){
    if(n == 1){
        cout << n << " ";
    }
    else{
        print(n - 1);
    	cout << n << " ";
    }
    
    
}