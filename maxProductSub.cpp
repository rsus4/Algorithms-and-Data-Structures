#include<iostream>
#include<vector>

using namespace std;


int maxProductSubarray(int arr[],int n){
	int min_till_i=1;
	int max_till_i=1;
	int best_so_far=1;
	for(int i=0;i<n;i++){
		if(arr[i]>0){
			if(min_till_i<0){
				min_till_i=min_till_i*arr[i];
			}
			max_till_i=max_till_i*arr[i];
			if(best_so_far<max_till_i){
				best_so_far=max_till_i;
			}
		}
		else{
			if(min_till_i<0){
				max_till_i=min_till_i*arr[i];
				min_till_i=1;
			}
			else{
				min_till_i=max_till_i*arr[i];
				max_till_i=1;
			}
			if(max_till_i>best_so_far){
				best_so_far=max_till_i;
			}
		}
		cout<<"min"<<min_till_i<<" max "<<max_till_i<<" best "<<best_so_far<<endl;
	}
	
	return best_so_far;
}

int main(){
	int n;
	cin>>n;
	int arr[n];
	for(int i=0;i<n;i++){
		cin>>arr[i];
	}
	int a=maxProductSubarray(arr,n);
	cout<<a<<endl;
}