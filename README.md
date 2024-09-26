Long Way
git add .
git commit -m ""
git push origin master
从远程库更新至本地:首先,执行git fetch命令，从远程仓库获取最新的提交信息。这将使本地仓库中的分支与远程仓库保持同步。
然后,使用git merge命令合并远程分支和本地分支。
例如,如果你的本地分支为master,可以执行以下命令 git merge origin/master git pull origin main 执行这个命令后，
Git 会自动 将远程仓库中的代码下载到本地仓库中，并与本地仓库中的代码合并。如果本地仓库和远程仓库中都有修改，
Git 会尝试自动合并代码， 但有时可能会出现冲突，需要手动解决冲突。 需要注意的是，在执行 git pull 命令之前，
你需要先将本地仓库中未提交的更改提交 到本地仓库或者撤销更改，否则 Git 会拒绝合并代码。