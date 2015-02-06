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

; this is a function with one parameter
; as "identity" is already a function, we name it otherwise
(defn identity-
  "as it returns the parameter, we call it identity"
  [x]
  x)

(identity- 1)
; 1
