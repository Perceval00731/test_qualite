#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* rle_encode(const char* input) {
    int len = strlen(input);
    if (len == 0) return "";

    int capacity = len * 2 + 1;
    char* encoded = (char*)malloc(capacity);
    if (!encoded) return NULL;

    int index = 0;
    char current_char = input[0];
    int count = 1;

    for (int i = 1; i < len; i++) {
        if (input[i] == current_char) {
            count++;
        } else {
            index += snprintf(encoded + index, capacity - index, "%d%c", count, current_char);
            current_char = input[i];
            count = 1;
        }
    }
    snprintf(encoded + index, capacity - index, "%d%c", count, current_char);
    return encoded;
}

int main() {
    char* test1 = rle_encode("");
    printf("Test 1 (\"\"): %s\n", test1);
    free(test1);

    char* test2 = rle_encode("abc");
    printf("Test 2 (\"abc\"): %s\n", test2);
    free(test2);

    char* test3 = rle_encode("abbccc");
    printf("Test 3 (\"abbccc\"): %s\n", test3);
    free(test3);

    char* test4 = rle_encode("aaabaa");
    printf("Test 4 (\"aaabaa\"): %s\n", test4);
    free(test4);

    char* test5 = rle_encode("aAa");
    printf("Test 5 (\"aAa\"): %s\n", test5);
    free(test5);

    char* test6 = rle_encode("WWWWWWWWWWWWW");
    printf("Test 6 (\"WWWWWWWWWWWWW\"): %s\n", test6);
    free(test6);

    return 0;
}