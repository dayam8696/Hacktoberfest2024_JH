#include <stdio.h>
#include <time.h>
struct item{
	int s_no,profit,weight,taken;
	float ratio;
};
int main(){
	time_t t1;
	time(&t1);
	int W,n,i=0;
	printf("Enter the size of the knapsack: ");
	scanf("%d",&W);
	printf("Enter the number of objects: ");
	scanf("%d",&n);
	struct item obj[n];
	float P=0;
	for(int i=0;i<n;i++){
		printf("Enter the profit of the object %d: ",i+1);
		scanf("%d",&obj[i].profit);
		printf("Enter the weight of the object %d: ",i+1);
		scanf("%d",&obj[i].weight);
		obj[i].ratio=(float)obj[i].profit/(float)obj[i].weight;
		obj[i].s_no=i+1;
	}
	for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1;j++){
            if(obj[j].ratio<obj[j+1].ratio){
              	struct item temp=obj[j];
                obj[j]=obj[j+1];
                obj[j+1]=temp;
            }
        }
    }
    while(i<n){
    	if(obj[i].weight<=W){
    		obj[i].taken=1;
    		W-=obj[i].weight;
    		P+=obj[i].profit;
    	}
    	else
    		obj[i].taken=0;
    	i++;
    }
    time_t t2;
	time(&t2);
	printf("The total time taken is : %ld\n",t2-t1);
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-1;j++){
            if(obj[j].ratio>obj[j+1].ratio){
              	struct item temp=obj[j];
                obj[j]=obj[j+1];
                obj[j+1]=temp;
            }
        }
    }
    printf("The item to be taken are:\n(0-Not Taken,1-Taken)\n");
    for(int i=0;i<n;i++)
    	printf("%d : %d \n", obj[i].s_no,obj[i].taken);
	return 0;
}
