{{- define "deployment.fullname" -}}
{{- .Values.global.env }}-{{- required "generic-application: Values.applicationName is required" .Values.applicationName }}
{{- end }}

{{- define "deployment.image.fullname" -}}
{{- required ".Values.image.name is required" .Values.image.name }}:{{- required ".Values.global.buildVersion" .Values.global.buildVersion }}
{{- end }}
