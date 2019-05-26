@echo off
FOR /L %%A IN (1,1,1000000000) DO (
copy "C:\\var\\opt\\mediation\\MMStorage\\Server1\\intercom\\temp\\*.txt" "C:\\var\\opt\\mediation\\MMStorage\\Server1\\intercom\\*
timeout 5
)