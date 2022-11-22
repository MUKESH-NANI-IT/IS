#include<stdio.h>
#include<string.h>
void main()
{
    int i,len;
    char str[] = "Hello World";
    len=strlen(str);
    for(i=0;i<len;i++)
    {
        printf("%c",str[i]&127);
    } 
    printf("\n");
    for ( i = 0; i < len; i++)
    {
        printf("%c",str[i]^127);
    }
    printf("\n");
    for ( i = 0; i < len; i++)
    {
        printf("%c",str[i]||127);
    }
    printf("\n");
}