#include <stdio.h>
#include <stdlib.h>

int main()
{
    int tam_vet, i, j, k, l, aux;
     printf("Digite a quantidade de numeros a serem verificados: ");
     scanf("%d", &tam_vet);
     int vet[tam_vet];
     printf("Digite os numeros a serem verificados: \n");
     for(k=0;k<tam_vet;k++){
          printf(" %d numero: ", k + 1);
          scanf("%d", &vet[k]);
     }
     for(i=0;i<tam_vet;i++){
        for(j=i+1;j<tam_vet;j++){
             if(vet[i]==vet[j]) continue;
             else{
                  if(vet[i]<vet[j]) continue;
                  else{
                       aux = vet[i];
                       vet[i] = vet[j];
                       vet[j] = aux;
                  }
             }
        }
     }
     printf("\nOs numeros ordenados sao: ");
     for(l=0;l<tam_vet;l++){
         printf("%d ", vet[l]);
     }
    return 0;
}
