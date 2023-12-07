import os

base_dir = "."  # 当前目录
output_file = "total.txt"

with open(output_file, "w", encoding="utf-8") as f_out:
    for root, dirs, files in os.walk(base_dir):
        for file in files:
            if file.endswith(".java"):
                file_path = os.path.join(root, file)
                with open(file_path, "r", encoding="utf-8") as f_in:
                    f_out.write(f_in.read())
                    f_out.write("\n\n")
