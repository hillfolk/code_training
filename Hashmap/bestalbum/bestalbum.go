package main

import (
	"fmt"
	"sort"
	)


func solution(genres []string, plays []int) []int {
	type album struct {
		idx int
		playCnt  int
	}
	
	var bestalbum = make([]int,0)
	var genresAlbum = make(map[string][]album)
	var genresAlbumVal = make(map[string]int)

	for i:=0; i < len(genres);i++ {
		_, exists := genresAlbum[genres[i]]
		if !exists{
			genresAlbum[genres[i]] = make([]album,len(genres))
			genresAlbum[genres[i]][i] = album{idx:i+1 , playCnt: plays[i]}
			genresAlbumVal[genres[i]] = genresAlbumVal[genres[i]] + plays[i]
			
		}else {
		
			genresAlbum[genres[i]][i] = album{idx:i+1 , playCnt: plays[i]}
			genresAlbumVal[genres[i]] = genresAlbumVal[genres[i]] + plays[i]
		}
	}

	for _, val := range genresAlbum {
		sort.Slice(val, func(i, j int) bool {
			result := false;
			if val[i].playCnt > val[j].playCnt {
				result = true;
			} else if val[i].playCnt == val[j].playCnt {

				if val[i].idx < val[j].idx {
					result = true
				}else
				{
					result = false
				}
			}else
			{
				result = false
			}
		return result
		})
	}
	
	sorted := map[int]string{}
	sortedKeys := []int{}
	for key, val := range genresAlbumVal {
		sorted[val]=key
		sortedKeys = append(sortedKeys, val)
	}
	sort.Sort(sort.Reverse(sort.IntSlice(sortedKeys)))
	var seletedCnt = 0;
	for _,val := range sortedKeys {
		seletedCnt = 0;
		for i:=0; i < len(genresAlbum[sorted[val]]);i++ {
			if genresAlbum[sorted[val]][i].idx > 0 {				
				bestalbum = append(bestalbum,genresAlbum[sorted[val]][i].idx-1)
				seletedCnt++
				if seletedCnt  >= 2 {
					break
				}
			}
		}
	}
	
	
	return bestalbum
}

func main() {
	var genres = []string{"pop", "pop", "pop", "classic", "pop","asdf"}
	var plays = []int{500, 500, 150, 800, 2500,123}
	
	fmt.Println(solution(genres,plays))
}
