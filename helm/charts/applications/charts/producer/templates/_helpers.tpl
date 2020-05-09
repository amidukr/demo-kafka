{{- define "deployment.fullname" -}}
{{- .Release.Name }}-{{- .Chart.Name }}
{{- end }}

