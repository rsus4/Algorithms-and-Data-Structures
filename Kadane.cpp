#include <iostream>
using namespace std;


int max_subarray(int arr[],int n){
	int current_max_ending=0;
	int best_so_far=0;
	for(int i=0;i<n;i++){
		if(current_max_ending+arr[i]<0){
			current_max_ending=0;
		}
		else{
			current_max_ending=current_max_ending+arr[i];
		}
		if(current_max_ending>best_so_far){
			best_so_far=current_max_ending;
		}
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
	int ans=max_subarray(arr,n);
	cout<<ans<<endl;
	return 0;
}