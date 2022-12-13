@REM reg add "HKEY_LOCAL_MACHINE\System\CurrentControlSet\Control\Session Manager\Environment" \v "Test" \d "a"
reg add %1 /v %2 /d %3 /f
