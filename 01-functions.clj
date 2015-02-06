;; a bit about clojure functions
; main source: https://clojuredocs.org/clojure.core/defn

; see (source defn)

; defn is the same as (def name (fn [params* ] exprs*)) or
; (def name (fn ([params* ] exprs*)+))

; this is a function without parameters
(defn no-params []
  8)

(no-params)
; 8
