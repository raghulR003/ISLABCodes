#include <stdio.h>
#include <string.h>

void vulnerable_function(char *input) {
    char buff[15];
    int pass = 0;

    // Vulnerable code 1: gets() - prone to buffer overflow
    gets(buff);

    // Vulnerable code 2: strcpy() - prone to buffer overflow
    strcpy(buff, input);

    // Vulnerable code 3: Unbounded loop writing to an array
    for (int i = 0; i < strlen(input); i++) {
        buff[i] = input[i];
    }

    // Vulnerable code 4: Using sprintf without buffer size check
    sprintf(buff, "%s", input);

    // Vulnerable code 5: Incorrect use of strncpy without proper termination
    strncpy(buff, input, sizeof(buff));

    if (strcmp(buff, "raghulr")) {
        printf("\n Wrong Password \n");
    } else {
        printf("\n Correct Password \n");
        pass = 1;
    }

    if (pass) {
        /* Now Give root or admin rights to user*/
        printf("\n Root privileges given to the user \n");
    }
}

int main(void) {
    char user_input[30];

    printf("\n Enter the password: \n");

    // Vulnerable code 6: gets() - prone to buffer overflow
    gets(user_input);

    // Vulnerable code 7: Unbounded loop writing to an array
    for (int i = 0; i < strlen(user_input); i++) {
        printf("%c", user_input[i]);
    }

    vulnerable_function(user_input);

    return 0;
}
