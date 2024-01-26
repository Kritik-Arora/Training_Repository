/*Build a simplified version of the StringBuilder class. Your custom class should support basic string manipulation operations such as:
Appending a string.
Inserting a string at a specific index.
Deleting a portion of the string*/
package String_Questions;

public class String_Builder {
    private char[] value;
    private int length;

    // Constructor to initialize an empty MyStringBuilder
    public String_Builder() {
        value = new char[16];
        length = 0;
    }

    // Append a string to the end of the MyStringBuilder
    public String_Builder append(String str) {
        ensureCapacity(length + str.length());
        for (char c : str.toCharArray()) {
            value[length++] = c;
        }
        return this;
    }

    // Insert a string at a specific index in the MyStringBuilder
    public String_Builder insert(int index, String str) {
        ensureCapacity(length + str.length());
        // Shift existing characters to make space for the new string
        System.arraycopy(value, index, value, index + str.length(), length - index);
        // Insert the new string at the specified index
        for (char c : str.toCharArray()) {
            value[index++] = c;
            length++;
        }
        return this;
    }

    // Delete a portion of the string in the MyStringBuilder
    public String_Builder delete(int start, int end) {
        if (start < 0 || start >= length || end <= start || end > length) {
            throw new StringIndexOutOfBoundsException("Invalid start or end index");
        }
        // Shift the remaining characters to remove the specified portion
        System.arraycopy(value, end, value, start, length - end);
        length -= (end - start);
        return this;
    }

    @Override
    public String toString() {
        return new String(value, 0, length);
    }

    // Ensure capacity to accommodate additional characters
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > value.length) {
            int newCapacity = Math.max(value.length * 2, minCapacity);
            char[] newValue = new char[newCapacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }
    }

    public static void main(String[] args) {
        String_Builder myStrBuilder = new String_Builder();
        myStrBuilder.append("Hello, ");
        myStrBuilder.append("world!");
        System.out.println(myStrBuilder.toString()); 

        myStrBuilder.insert(7, "awesome ");
        System.out.println(myStrBuilder.toString()); 
        myStrBuilder.delete(7, 15);
        System.out.println(myStrBuilder.toString()); 
    }
}
