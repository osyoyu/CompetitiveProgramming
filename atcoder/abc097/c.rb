def substrings(str)
  output = []
  (0...str.length).each do |i|
    (i...str.length).each do |j|
      output << str[i..j]
    end
  end
  output
end

S = gets.chomp
K = gets.chomp.to_i

#puts substrings(S).uniq.sort[K-1]

alphabets = S.split('').uniq.sort
substrs = []

alphabets.each do |a|
  positions = (0..S.length).find_all {|i| S[i] == a }
  positions.each do |pos|
    substrs << S[pos,K]
  end
  break if substrs.size >= K
end

candidates = substrs.map {|substr|
  substrings(substr)
}.flatten.uniq.sort

puts candidates[K-1]
