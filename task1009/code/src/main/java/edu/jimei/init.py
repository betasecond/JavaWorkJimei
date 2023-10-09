def create_java_files():
    template = """
public class Solution{num} {{
    public static void main(String[] args) {{
        // Your code here
    }}
}}
    """
    
    for i in range(1, 11):
        filename = f"Solution{i}.java"
        with open(filename, 'w') as file:
            file.write(template.format(num=i))

if __name__ == "__main__":
    create_java_files()
