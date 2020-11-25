#include<iostream>
#include<algorithm>  
using namespace std;

typedef long long ll;
ll kadane(ll arr[],int n){
	ll current_max_ending=0;
	ll best_so_far=0;
	for(int i=0;i<n;i++){
		if(current_max_ending+arr[i]>0){
			current_max_ending=current_max_ending+arr[i];
		}
		else{
			current_max_ending=0;
		}
		if(best_so_far<current_max_ending){
			best_so_far=current_max_ending;
		}
	}
	return best_so_far;
}

ll kadane2(ll arr[],int n){
	ll current_max_ending=0;
	ll best_so_far=0;
	for(int i=n-1;i>=0;i++){
		if(current_max_ending+arr[i]>0){
			current_max_ending=current_max_ending+arr[i];
		}
		else{
			current_max_ending=0;
		}
		if(best_so_far<current_max_ending){
			best_so_far=current_max_ending;
		}
	}
	return best_so_far;
}

int main(){
	int t;
	cin>>t;
	for(int l=0;l<t;l++){
		int n,k;
		cin>>n;
		cin>>k;
		ll arr[n];
		ll sum1;
		for(int i=0;i<n;i++){
			cin>>arr[i];
			sum1+=arr[i];
		}
		if(sum1>0){
			ll suffix=kadane2(arr,n);
			ll prefix=kadane(arr,n);
			ll third=sum1*(k-2);
			ll ans1=suffix+prefix+third;
			ll ans2=prefix;

			cout<<max(ans1,ans2)<<endl;
		}
		else{
			if(k>=2){
			ll arr2[2*n];
			for(int i=0;i<n;i++){
				arr2[i]=arr[i];
			}
			for(int i=0;i<n;i++){
				arr2[i+n]=arr[i];
			}
			cout<<max(kadane(arr2,2*n),kadane(arr,n))<<endl;
			}
			else{
				cout<<kadane(arr,n)<<endl;
			}
			
		}

	}
	return 0;
}