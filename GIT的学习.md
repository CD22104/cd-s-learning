# GIT的学习

根据廖雪峰的教程https://www.liaoxuefeng.com/wiki/896043488029600

## GIT简介

- git的诞生：git是用c语言开发的

- 集中式，分布式：

  - 集中式把版本库放在中央服务器工作时从中央服务器得到最新版本到自己的电脑，完成后再将其退给服务器

    应用：CVS——最早，开源，免费，易造成提交不完整，版本库损坏；SVN（CVS修改后）——免费，开源，稳定（目前用的最多的集中式）

    > 需要联网，可能导致速度慢。

  - 高安全性，每个人的电脑都有完整的版本库，也有充当”中央服务器“的电脑，作用仅为方便修改和交换

    > 不必联网，强大的分支管理

## GIT的安装和创建版本库

- 进入git bash，设置个人信息，`git config --global user.name "My name"`,`git config --global user.email "email@example.com"`

- 创建版本库（又名仓库，repository），通过git init 将其变成仓库，把文件添加到版本库`git add readme.txt`,`git commit -m "write a readme file"`

  > 版本控制系统只能跟踪文本文件的改动，也不能用word
  >
  > pwd可用于显示当前位置

## 时光机穿梭

- 版本回退 git log查看历史记录
  1. git log  --pretty=oneline   筛选，会出现commit id 版本号
  2. git中，head为当前版本，上一个版本为HEAD^，再上为head^^,往上一百个是head~100 ，回退到上一个版本 git reset --hard HEAD^, 此时git log 会发现原本记录消失，使用git reset --hard 8a37（版本号前几位）
  3. 使用git reflog，查看每一次命令
- 工作区和暂存区（git特有）
  1. 工作区：在电脑看到的文件夹，目录
  2. 版本库（工作区隐藏目录，git）：里面有暂存区（stage/index），第一个分支master的指针HEAD，git add 就是放入stage ，git commit是提交到分支
  3. 使用git status查看状态（工作区）
- 管理修改
  1. git管理跟踪的是修改而非文件。第一次修改->add->第二次修改->commit，第二次修改未被提交
  2. 用git diff HEAD --readme.txt 查看工作区版本库里面最新版本的区别
- 撤销修改
  1. git checkout --readme.txt （若无--则切换到另一分支），把此文件在工作区的修改全部撤销
     - 若未放入暂存区，撤消后回到原样
     - 若放入stage后修改，撤回到添加到暂存区的状态
  2. git reset HEAD readme.txt可以把暂存区的修改撤销放回工作区（保留修改），再用git checkout丢弃工作区的修改
- 删除文件
  - 在本地用rm删除文件后，git status可是哪些文件被删，接下来
    - 在版本库删除文件，git rm text.text/git commit -m "remove"
    - 用 git checkout --text.text 误删，用版本库版本替换工作区版本

## 远程仓库

- github 仓库与本地仓库之间的传输通过ssh加密。需添加设置
- 关联远程库。 git remote add origin git@github.com/....
- 将本地库所有内容推至远程库 git push -u origin master(-u:第一次推送+关联本地master远程)
- 本地作为提交后，可通过git push origin master 推至github
- 从远程克隆git clone git@github.com:...

## 分支管理

- 创建与合并分支 

  主分支 master指向提交，HEAD指向当前分支

  git checkout -b dev(-b ：创建并切换)      相当于    git branch dev/git checkout dev

  git branch 查看分支

  git merge dev 合并分支

  git branch -d dev 删除分支

  git switch -c dev （用switch更科学  -c：创建并切换，去掉或直接切换）

  git log --graph --pretty=oneline --abbrev-commit可以查看分支的合并情况

- 分支管理策略

  一般情况下使用merge都会成为fast-forward合并，要想关闭fast-forward则用$ git merge --no-ff -m "merge with no-ff" dev会在保留分支的情况下重新建一个文件

- bug分支

  1. 在修复bug时，手头工作还没做完，可以使用git stash暂存，可用git stash list查看，恢复git stash apply( stash @{o}    指定)

     同时用git stash drop 删除，或使用git stash pop 一步到位

  2. 若要把bug文件中的修改复制到当前文件，git cherry-pick 4c805e2(版本号)

-  Feature分支

  每新建一个功能，新建一个分支

  若add后需要删除，用-d失败，要用-D git brand -D feature  强行删除

- 多人协作

  1. 查看远程库信息 git remote (-v 显示详细的信息)
  2. 推送分支 git push origin master 主分支    dev开发分支，feature合作在此开发，bug修复可不推
  3. 在克隆时默认只能看到master 若要复制dev 则git checkout -b dev origin/dev
  4. 若两人皆在dev分支上有提交，则git pull 先拉取最新的对方的提交，在本地合并解决冲突，若git pull失败，先设置dev和origin/dev的链接，如git branch --set-upstream-to = origin/dev dev 完成提交后，push dev

- rebase /git rebase 可以使分叉的记录变为一条直线，最终的提交内容一致，但本地的分叉提交被修改

## 标签管理

取某个标签的版本，就是把那个打标签时刻的历史版本拿出来

- 创建标签

  切换到此分支 用`git tag <name>`打标签，默认为HEAD。用git tag 可查看所有标签，对过去的版本打标签，git tag name 版本号，标签是按字母的顺序排的，用，`git show <tagname>`可看到信息

-  操作标签

  1. 删除 git tag -d v1.0
  2. 因标签都在本地所以没关系 ，若要推到远程用git push origin v1.0 若推到远程先从本地删除，再从远程删除 git tag -d v1.0/git push origin :refs/tags/v0.9

## 自定义git

- 让git显示颜色 git config --global color.ui true

- 忽略特殊文件：在git工作区的根目录下创建gitigore文件，把要忽略的文件名输进去

  1. 忽略文件的原则：忽略操作系统的自动生成文件，编译的中间文件，敏感信息（存放口令）的文件
  2. 把.gitignore提交到git就可以了
  3. 有的时候无法提交可能是被忽略了，确实想添加，可用-f强制添加`git add -f <filename>`
  4. 可以用`git check-ignore -v <filename>` 检查.gitinore文件问题

- 配置别名

  git config --global alias.st status （global：全局参数，此命令在此电脑下所有git仓库都适用）从此可用git st代替git status 配置文件一般放在.git/config文件中，别名放在alias的后面