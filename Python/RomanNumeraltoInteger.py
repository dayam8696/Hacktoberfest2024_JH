def roman_to_int(s):
    """
    Converts a Roman numeral to an integer.

    :param s: A string representing a Roman numeral.
    :return: An integer equivalent of the Roman numeral.
    """
    roman = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    total = 0
    prev_value = 0
    
    for char in s:
        current_value = roman[char]
        total += current_value
        if current_value > prev_value:
            total -= 2 * prev_value
        prev_value = current_value
    
    return total

# Example usage:
print(roman_to_int("MCMXCIV"))  # Output: 1994
