
import os

def collect_java_files(root_dir, output_file):
    with open(output_file, 'w', encoding='utf-8') as outfile:  # Ensure writing with UTF-8
        for root, dirs, files in os.walk(root_dir):
            for file in files:
                if file.endswith('.java'):
                    file_path = os.path.join(root, file)
                    with open(file_path, 'r', encoding='utf-8') as infile:  # Ensure reading with UTF-8
                        outfile.write(f'// Filename: {file}\n')
                        try:
                            outfile.write(infile.read() + '\n\n')
                        except UnicodeDecodeError as e:
                            print(f'Error reading {file_path}: {e}')


# 使用方法：指定源代码所在的顶级目录和输出文件的路径
source_dir = './'  # 需要更改为你的实际路径
output_file_path = './code.txt'  # 需要更改为你的实际路径
collect_java_files(source_dir, output_file_path)
